import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {ProductInfo} from '../models/productInfo';
import {apiUrl} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl = `${apiUrl}/product`;
  private categoryUrl = `${apiUrl}/category`;

  constructor(private http: HttpClient) {
  }

  getAllInPage(page: number, size: number): Observable<any> {
    const url = `${this.productUrl}?page=${page}&size=${size}`;
    return this.http.get(url)
      .pipe(
      );
  }

  getCategoryInPage(categoryType: number, page: number, size: number): Observable<any> {
    const url = `${this.categoryUrl}/${categoryType}?page=${page}&size=${size}`;
    return this.http.get(url).pipe(
    );
  }

  getDetail(id: String): Observable<ProductInfo> {
    const url = `${this.productUrl}/${id}`;
    return this.http.get<ProductInfo>(url).pipe(
      catchError(_ => {
        console.log('Error al obtener detalle');
        return of(new ProductInfo());
      })
    );
  }

  update(productInfo: ProductInfo): Observable<ProductInfo> {
    const url = `${apiUrl}/seller/product/${productInfo.productId}/edit`;
    return this.http.put<ProductInfo>(url, productInfo);
  }

  create(productInfo: ProductInfo): Observable<ProductInfo> {
    const url = `${apiUrl}/seller/product/new`;
    return this.http.post<ProductInfo>(url, productInfo);
  }


  delete(productInfo: ProductInfo): Observable<ProductInfo> {
    const url = `${apiUrl}/seller/product/${productInfo.productId}/delete`;
    return this.http.delete<ProductInfo>(url);
  }
}
