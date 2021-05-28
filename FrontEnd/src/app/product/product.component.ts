import { Product } from './../model/product';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ImageDetail } from '../model/image-detail';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productName: String = '';
  product!: Product;
  IsPromotion = false;
  imageDetails: Array<ImageDetail> = [];
  imageId!: number;

  constructor(private router : Router, private route: ActivatedRoute, private userService: UserService) { }

  ngOnInit(): void {
    this.productName = this.route.snapshot.params['name'];
    this.getProductDetail(this.productName);
  }

  getProductDetail(name: String){
    this.userService.getProductDetail(name)
          .subscribe(
            (data: Product) => {
              this.product = data; 
              if(this.product.price > 0)
              {
                this.IsPromotion = true;
              }
              this.imageId = this.product.id;
              this.userService.getImageDetail(this.imageId)
                .subscribe(
                  (data: ImageDetail[]) => {
                    this.imageDetails = data; 
                  },
                  error => {
                    console.log(error);
                  }
                );
            },
            error => {
              console.log(error);
            });
  }
}
