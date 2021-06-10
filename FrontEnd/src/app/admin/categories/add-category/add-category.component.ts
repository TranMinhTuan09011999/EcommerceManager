import { UserService } from 'src/app/service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
  name!: string;
  isAddMode!: boolean;
  form!: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private userService: UserService) { }

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
    this.isAddMode = !this.name;
    
    this.form = this.formBuilder.group({
    })
  }

}
