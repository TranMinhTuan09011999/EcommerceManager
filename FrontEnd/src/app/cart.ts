import { Product } from "./product";

export class Cart {
    id!: number;
    product!: Product;
    quantity!: number;
    price!: number;
    userId!: number;
}
