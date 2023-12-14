export interface CreditsResponse{
    id?: number;
    cast?: PersonResult[];
    crew?: CrewResult[];
}

export interface PersonResult{
    cast_id?: number;
    character?: string;
    credit_id?: string;
    gender?: number | null;
    id?: number;
    name?: string;
    order?: number;
    profile_path?: string | null;
    picture_path?: string;
}

export interface CrewResult{
    credit_id?: string;
    department?: string;
    gender?: number | null;
    id?: number;
    job?: string;
    name?: string;
    profile_path?: string | null;
}