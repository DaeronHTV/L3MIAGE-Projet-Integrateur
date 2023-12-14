export interface ReviewQuery {
    language?: string; // default "en-US"
}

export interface SearchReviewResponse {
    id?: number
    page?: number;
    results?: ReviewResult[];
    total_results?: number;
    total_pages?: number;
}

export interface ReviewResult{
    id?: string;
    author?: string;
    content?: string;
    url?: string;
}