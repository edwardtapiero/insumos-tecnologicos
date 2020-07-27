import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {OrderService} from '../../services/order.service';
import {Order} from '../../models/Order';
import {ActivatedRoute} from '@angular/router';

@Component({
    selector: 'app-order-detail',
    templateUrl: './order-detail.component.html'
})
export class OrderDetailComponent implements OnInit {

    constructor(private orderService: OrderService,
                private route: ActivatedRoute) {
    }

    order$: Observable<Order>;

    ngOnInit(): void {
        this.order$ = this.orderService.show(this.route.snapshot.paramMap.get('id'));
    }

}
