import {MovieResult} from './searchMovie';
import {TVResult} from './SearchTV';

export interface SearchPeopleQuery {
  language?: string; // Pass a ISO 639-1 value to display translated data for the fields that support it.
                    // default: en-US
  query: string;
  page?: number;
  include_adult?: boolean;
  region?: string;
}

export interface SearchPeopleResponse {
  page?: number;
  results?: {
    profile_path?: string;
    adult?: boolean;
    id?: number;
    known_for?: MovieResult | (TVResult & {media_type: string; /* Allowed Values: tv */});
  }[];
  name?: string;
  popularity?: number;
  total_results?: number;
  total_pages?: number;
}

export interface PeoplePictureResponse{
  id?: number;
  profiles?: PictureResult[];
}

export interface PictureResult{
  aspect_ratio?: number;
  file_path?: string;
  height?: number;
  iso_639_1?: null;
  vote_average?: number | null;
  vote_count?: number;
  width?: number;
}
