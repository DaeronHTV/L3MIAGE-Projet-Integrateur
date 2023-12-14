export interface Query {
    language?: string; // default "en-US"
}

export interface BDDPlat{
    plats: Plat[];
    total?: number;
}

export interface Plat{
    id: string;
    langage?: string;
    genre?: string;
    ingredients: Ingredient[];
    nom: string;
    type: string;
    prix: number;
    photo: string;
}

export interface PlatResponse{
    page?: number;
    listplat: Plat[];
    total_result?: number;
    total_pages?: number;
}

export interface PlatQuery{
    query: string;
    page?: number; //default 1 minimum 1 maximum 3
}

export interface Ingredient{
    id?: number;
    ingredient: string;
}
