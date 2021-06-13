import { Product } from './../model/product';
import { Category } from './../model/category';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { ImageDetail } from '../model/image-detail';
import { User } from '../model/user';

const API_URL = 'http://localhost:8080/api/user/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  /*getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }*/

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(API_URL + 'products')
      .pipe(retry(3),
          catchError(this.handleError));
  }

  getCategory(): Observable<Category[]>{
    return this.http.get<Category[]>(API_URL + 'category')
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }

  getCategoryByName(name: string): Observable<Category>{
    return this.http.get<Category>(API_URL + 'category/' + name)
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }


  getPromotionProduct(): Observable<Product[]>{
    return this.http.get<Product[]>(API_URL + 'promotion')
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };

  getProductByCategory(name: String): Observable<Category>{
    return this.http.get<Category>(API_URL + 'category/' + name)
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }

  getProductDetail(name: String): Observable<Product>{
    return this.http.get<Product>(API_URL + 'product/' + name)
                  .pipe(
                    retry(3),
                    catchError(this.handleError)
                  );
  }

  getImageDetail(imageId: number): Observable<ImageDetail[]>{
    return this.http.get<ImageDetail[]>(API_URL + 'product/detail/' + imageId)
                  .pipe(
                    retry(3),
                    catchError(this.handleError)
                  );
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(API_URL + 'get-all')
                  .pipe(
                    retry(3),
                    catchError(this.handleError))
  }
}
