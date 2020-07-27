import {Component, OnDestroy, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {OrderService} from '../../services/order.service';
import {OrderStatus} from '../../enum/OrderStatus';
import {Subscription} from 'rxjs';
import {UserService} from '../../services/user.service';
import {ActivatedRoute} from '@angular/router';
import {JwtResponse} from '../../response/JwtResponse';
import {Role} from '../../enum/Role';

@Component({
  selector: 'app-administrator',
  templateUrl: './administrator.component.html'
})

export class AdministratorComponent implements OnInit, OnDestroy {

  page: any;
  countStatus: any[];
  countUser: any[];
  currentUser: JwtResponse;
  OrderStatus = OrderStatus;
  Role = Role;

  constructor(private httpClient: HttpClient,
              private userService: UserService,
              private orderService: OrderService,
              private route: ActivatedRoute) {
  }

  querySub: Subscription;

  ngOnInit(): void {
    this.currentUser = this.userService.currentUserValue;
    this.querySub = this.route.queryParams.subscribe(() => {
      this.getOrder();
    });
  }

  getOrder(): void {
    let nextPage = 1;
    let size = 10;
    if (this.route.snapshot.queryParamMap.get('page')) {
      nextPage = +this.route.snapshot.queryParamMap.get('page');
      size = +this.route.snapshot.queryParamMap.get('size');
    }
    this.orderService.getPage(nextPage, size).subscribe(page => {
      this.page = page;

      const order = this.page?.content;

      const countByStatus = order.reduce((acc, cur) => {
        acc[cur.orderStatus] = (acc[cur.orderStatus] || 0) + 1;
        return acc;
      }, {});

      const countByBuyer = order.reduce((acc, cur) => {
        acc[cur.buyerName] = (acc[cur.buyerName] || 0) + 1;
        return acc;
      }, {});

      this.countStatus = Object.keys(countByStatus).map(key => ({orderStatus: key, count: countByStatus[key]}));
      this.countUser = Object.keys(countByBuyer).map(key => ({buyerName: key, count: countByBuyer[key]}));
      console.log(this.countUser);

    }, _ => {
      console.log('Falla al obtener pedido');
    });
  }

  ngOnDestroy(): void {
    this.querySub.unsubscribe();
  }
}
