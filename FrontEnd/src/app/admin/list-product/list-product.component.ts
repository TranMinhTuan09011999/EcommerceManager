import { Product } from './../../model/product';
import { Category } from './../../model/category';
import { ActivatedRoute } from '@angular/router';
import { AfterContentChecked, AfterContentInit, AfterViewChecked, Component, DoCheck, Input, OnChanges, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements DoCheck {

  categoryName: string = '';
  products: Array<Product> = [];

  constructor(private route: ActivatedRoute, 
              private userService: UserService) { }


  ngDoCheck(): void {
    this.categoryName = this.route.snapshot.params['categoryName'];
    this.getProduct(this.categoryName);
  }

  // ngAfterContentChecked() {
  //   this.getProduct(this.categoryName);
  // }

  getProduct(name: String){
    this.userService.getProductByCategory(name)
      .subscribe(
        (data: Category) => {
          this.products = data.products;
        },
        error => {
          console.log(error);
        });
    console.log(this.products);
  }

}
