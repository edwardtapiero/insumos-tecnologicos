import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Role} from '../../enum/Role';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

  isInvalid: boolean;
  isLogout: boolean;
  submitted = false;
  model: any = {
    username: '',
    password: '',
    remembered: false
  };

  returnUrl = '/';

  constructor(private userService: UserService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    const params = this.route.snapshot.queryParamMap;
    this.isLogout = params.has('logout');
    this.returnUrl = params.get('returnUrl');
  }

  onSubmit(): void {
    this.submitted = true;
    this.userService.login(this.model).subscribe(
      user => {
        if (user) {
          if (user.role !== Role.Customer) {

            this.returnUrl = '/admin';
          }

          this.router.navigateByUrl(this.returnUrl);
        } else {
          this.isLogout = false;
          this.isInvalid = true;
        }

      }
    );
  }

  fillLoginFields(u, p): void {
    this.model.username = u;
    this.model.password = p;
    this.onSubmit();
  }
}
