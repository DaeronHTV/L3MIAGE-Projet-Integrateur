import { Item } from 'src/app/entity/item.entity';

/********Pour les interfaces Responses********/
export function HaveAGender(item: any): boolean{return item.genres.length !== 0;}
/********Pour les interfaces Result********/

/********Pour Toutes interfaces********/
export function HaveAFilm(item: any): boolean{return item !== undefined;}
export function HaveASerie(item: any): boolean{return item !== undefined;}
export function HavePopularity(item: any): boolean{return item.popularity !==0;}
export function HaveVote(item: any): boolean{return item.vote_count !==0;}
export function HaveABackPicture(item: any): boolean{return item.backdrop_path !== null}
export function HaveAPosterPicture(item: any): boolean{return item.poster_path !== null;}
export function HaveADescription(item: any): boolean{return item.overview !== "";}
export function HaveAnOriginalLanguage(item: any): boolean{return item.original_language !== null;}
/********Pour les interface film********/
export function ForAdult(item: any): boolean{return item.adult;}
export function HaveAPublishedYear(item: any): boolean{return item.release_date !== "";}
export function HaveBudget(item: any): boolean{return item.budget !==0;}
export function HaveDuration(item: any): boolean{return item.runtime !==0;}
/********Pour les interfaces séries*****/
export function HaveACreationYear(item: any): boolean{return item.first_air_date !== null;}
export function HaveARealisator(item: any): boolean{return item.created_by.length !== 0;}
export function HaveAEpisodeRuntime(item: any): boolean{return item.episode_run_time.length !== 0;}
/********Pour les interfaces plat*******/
export function HaveIngredient(item: any): boolean{return item.ingredients.length !== 0;}
/******Pour les interfaces personnes******/
export function haveAFacePicture(item: any): boolean{return item.profile_path !== null;}