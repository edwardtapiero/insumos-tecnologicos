import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {OrderService} from '../../services/order.service';
import {Order} from '../../models/Order';
import {OrderStatus} from '../../enum/OrderStatus';
import {UserService} from '../../services/user.service';
import {JwtResponse} from '../../response/JwtResponse';
import {Subscription} from 'rxjs';
import {ActivatedRoute} from '@angular/router';
import {Role} from '../../enum/Role';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html'
})
export class OrderComponent implements OnInit, OnDestroy {

  page: any;
  OrderStatus = OrderStatus;
  currentUser: JwtResponse;
  Role = Role;

  constructor(private httpClient: HttpClient,
              private orderService: OrderService,
              private userService: UserService,
              private route: ActivatedRoute
  ) {
  }

  querySub: Subscription;

  ngOnInit(): void {
    this.currentUser = this.userService.currentUserValue;
    this.querySub = this.route.queryParams.subscribe(() => {
      this.update();
    });
  }

  update(): void {
    let nextPage = 1;
    let size = 10;
    if (this.route.snapshot.queryParamMap.get('page')) {
      nextPage = +this.route.snapshot.queryParamMap.get('page');
      size = +this.route.snapshot.queryParamMap.get('size');
    }
    this.orderService.getPage(nextPage, size).subscribe(page => this.page = page, _ => {
      console.log('Falla al obtener pedido');
    });
  }


  cancel(order: Order): void {
    this.orderService.cancel(order.orderId).subscribe(res => {
      if (res) {
        order.orderStatus = res.orderStatus;
      }
    });
  }

  authorized(order: Order): void {
    this.orderService.authorized(order.orderId).subscribe(res => {
      if (res) {
        order.orderStatus = res.orderStatus;
      }
    });
  }

  received(order: Order): void {
    this.orderService.received(order.orderId).subscribe(res => {
      if (res) {
        order.orderStatus = res.orderStatus;
      }
    });
  }

  ngOnDestroy(): void {
    this.querySub.unsubscribe();
  }

}
