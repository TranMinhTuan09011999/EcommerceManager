import { ListCategoriesComponent } from './categories/list-categories/list-categories.component';
import { AdminComponent } from './admin.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListProductComponent } from './products/list-product/list-product.component';
import { EditProductComponent } from './products/edit-product/edit-product.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { AddCategoryComponent } from './categories/add-category/add-category.component';
import { UsersComponent } from './users/users.component';

const routes: Routes = [
  { path: 'admin', component: AdminComponent, 
      children: [
        {path: 'products', component: ListProductComponent},
        {path: 'edit/:name', component: EditProductComponent},
        {path: 'add-product', component: AddProductComponent},
        {path: 'categories', component: ListCategoriesComponent},
        {path: 'add-category', component: AddCategoryComponent},
        {path: 'edit-category/:name', component: AddCategoryComponent},
        {path: 'users', component: UsersComponent}
      ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
