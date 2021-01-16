import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  public products;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:8888/INVENTORY-SERVICE/inventories")
      .subscribe(data => {
        this.products=data;
        console.log(data);
      },error => {
        console.log(error);
      })
  }

}
