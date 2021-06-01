import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { ListProductComponent } from './list-product/list-product.component';


@NgModule({
  declarations: [
    AdminComponent,
    ListProductComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ],
  providers: [],
  bootstrap: [AdminComponent]
})
export class AdminModule { }
