export interface Responses{
    type: string;
    response: any;
}

export interface Query{
    categorie: string;
    query: string;
    doresearch: boolean;
}

export interface ResearchSumUp{
    query: Query;
    responses: Responses[];
}