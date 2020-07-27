import {Component, OnInit} from '@angular/core';
import {Location} from '@angular/common';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html'
})
export class SignupComponent implements OnInit {

  user: User;

  constructor(private location: Location,
              private userService: UserService,
              private router: Router) {
    this.user = new User();

  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.userService.signUp(this.user).subscribe(u => {
        this.router.navigate(['/login']);
      },
      e => {
      });
  }

}
