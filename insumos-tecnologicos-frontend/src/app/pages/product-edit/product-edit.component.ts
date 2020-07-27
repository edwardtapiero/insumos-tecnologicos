import {AfterContentChecked, Component, OnInit} from '@angular/core';
import {ProductInfo} from '../../models/productInfo';
import {ProductService} from '../../services/product.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html'
})
export class ProductEditComponent implements OnInit, AfterContentChecked {

  product = new ProductInfo();

  constructor(private productService: ProductService,
              private route: ActivatedRoute,
              private router: Router) {
  }

  productId: string;
  isEdit = false;

  ngOnInit(): void {
    this.productId = this.route.snapshot.paramMap.get('id');
    if (this.productId) {
      this.isEdit = true;
      this.productService.getDetail(this.productId).subscribe(prod => this.product = prod);
    }

  }

  update(): void {
    this.productService.update(this.product).subscribe(prod => {
        if (!prod) {
          throw new Error();
        }
        this.router.navigate(['/admin']);
      },
      err => {
      });

  }


  remove(): void {
    this.productService.delete(this.product).subscribe(r => {
      this.router.navigate(['/admin']);
    });
  }

  onSubmit(): void {
    if (this.productId) {
      this.update();
    } else {
      this.add();
    }
  }

  add(): void {
    this.productService.create(this.product).subscribe(prod => {
        if (!prod) {
          throw new Error;
        }
        this.router.navigate(['/']);
      },
      e => {
      });
  }

  ngAfterContentChecked(): void {
    console.log(this.product);
  }
}
