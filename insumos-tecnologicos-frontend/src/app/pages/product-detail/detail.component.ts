import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../services/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CartService} from '../../services/cart.service';
import {CookieService} from 'ngx-cookie-service';
import {ProductInOrder} from '../../models/ProductInOrder';
import {ProductInfo} from '../../models/productInfo';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html'
})
export class DetailComponent implements OnInit {
  title: string;
  count: number;
  productInfo: ProductInfo;

  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private cookieService: CookieService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.getProduct();
    this.title = 'Detalle de producto';
    this.count = 1;
  }

  getProduct(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.productService.getDetail(id).subscribe(
      prod => {
        this.productInfo = prod;
      },
      _ => console.log('Error al añadir al carrito')
    );
  }

  addToCart(): void {
    this.cartService
      .addItem(new ProductInOrder(this.productInfo, this.count))
      .subscribe(
        res => {
          if (!res) {
            console.log('Error al añadir' + res);
            throw new Error();
          }
          this.router.navigateByUrl('/carrito');
        },
        _ => console.log('Error al añadir')
      );
  }

  validateCount(): void {
    const max = this.productInfo.productStock;
    if (this.count > max) {
      this.count = max;
    } else if (this.count < 1) {
      this.count = 1;
    }
  }
}
