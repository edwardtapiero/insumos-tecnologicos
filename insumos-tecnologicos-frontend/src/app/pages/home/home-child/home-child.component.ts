import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-home-child',
  templateUrl: './home-child.component.html'
})
export class HomeChildComponent implements OnInit {

  @Input() productInfo: any = {};

  constructor() { }

  ngOnInit(): void {
  }

}
