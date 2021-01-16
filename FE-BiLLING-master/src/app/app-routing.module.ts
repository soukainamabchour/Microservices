import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductComponent} from './product/product.component';
import {CustomerComponent} from './customer/customer.component';
import {BillComponent} from './bill/bill.component';

const routes: Routes = [
  {
    path: "products",
    component: ProductComponent
  },
  {
    path: "customers",
    component: CustomerComponent
  },
  {
    path: "fullBill",
    component: BillComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
