import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {LoginComponent} from './pages/login/login.component';
import {SignupComponent} from './pages/signup/signup.component';
import {DetailComponent} from './pages/product-detail/detail.component';
import {CartComponent} from './pages/cart/cart.component';
import {AuthGuard} from './_guards/auth.guard';
import {OrderComponent} from './pages/order/order.component';
import {OrderDetailComponent} from './pages/order-detail/order-detail.component';
import {ProductListComponent} from './pages/product-list/product.list.component';
import {UserDetailComponent} from './pages/user-edit/user-detail.component';
import {ProductEditComponent} from './pages/product-edit/product-edit.component';
import {Role} from './enum/Role';
import {AdministratorComponent} from './pages/administrator/administrator.component';

const routes: Routes = [
  {path: '', redirectTo: 'inicio', pathMatch: 'full'},
  {path: 'producto/:id', component: DetailComponent},
  {path: 'categoria/:id', component: HomeComponent},
  {path: 'inicio', component: HomeComponent},
  {path: 'categoria', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LoginComponent},
  {path: 'registrar', component: SignupComponent},
  {path: 'carrito', component: CartComponent},
  {path: 'success', component: SignupComponent},
  {path: 'pedido/:id', component: OrderDetailComponent, canActivate: [AuthGuard]},
  {path: 'pedidos', component: OrderComponent, canActivate: [AuthGuard]},
  {path: 'admin', redirectTo: 'admin/producto', pathMatch: 'full'},
  {
    path: 'admin/producto',
    component: ProductListComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Manager]}
  },
  {
    path: 'perfil',
    component: UserDetailComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'admin/producto/:id/edit',
    component: ProductEditComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Manager]}
  },
  {
    path: 'admin/producto/new',
    component: ProductEditComponent,
    canActivate: [AuthGuard],
    data: {roles: [Role.Manager]}
  },
  {
    path: 'admin/pedidos',
    component: AdministratorComponent,
    canActivate: [AuthGuard]
  },

];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
