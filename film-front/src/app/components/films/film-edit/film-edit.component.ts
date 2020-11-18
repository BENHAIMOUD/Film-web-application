import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmService } from '../../../services/film.service';
import { Film } from '../../../models/film.model';
import { ModelHelper } from '../../../shared/model.helper';
import { Actor } from '../../../models/actor.model';
import { Director } from '../../../models/director.model';
import { Observable } from 'rxjs/Observable';
import { forkJoin } from 'rxjs/observable/forkJoin';
import { FilmDetailComponent } from '../film-detail/film-detail.component';
import { MatDialog, MatDialogRef, MatSnackBar } from '@angular/material';
import { AddItemComponent } from '../../shared/add-item/add-item.component';
import { SearchService } from '../../../services/search.service';
import { ActorService } from '../../../services/actor.service';
import { AppConfig } from '../../../config/app.config';
import { FormControl, FormGroupDirective, NgForm, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { Utils } from '../../../shared/utils';
import { DirectorService } from '../../../services/director.service';


export class TitleStateMatcher implements ErrorStateMatcher {
  isErrorState(titleControl: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(titleControl && titleControl.invalid && (titleControl.dirty || titleControl.touched || isSubmitted));
  }
}

export class PosterStateMatcher implements ErrorStateMatcher {
  isErrorState(posterControl: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(posterControl && posterControl.invalid && (posterControl.dirty || posterControl.touched || isSubmitted));
  }
}


@Component({
  selector: 'app-film-edit',
  templateUrl: './film-edit.component.html',
  styleUrls: ['./film-edit.component.css']
})
export class FilmEditComponent implements OnInit {

  isNew: boolean ;

  film: Film;

  actors: Actor[];

  directors: Director[];

  titleFormControl = new FormControl('', [
    Validators.required
  ]);


  posterFormControl = new FormControl('', [
    Validators.required,
    Validators.pattern(Utils.getUrlPattern())
  ]);

  titleStateMatcher = new TitleStateMatcher() ;
  posterStateMatcher = new TitleStateMatcher();

  constructor(
    private route: ActivatedRoute,
    private filmService: FilmService,
    private modelHelper: ModelHelper,
    private dialog: MatDialog,
    private searchService: SearchService,
    private actorService: ActorService,
    private directorService: DirectorService,
    private snackBar: MatSnackBar
  ) {
    this.film = modelHelper.createNewFilm() ;
    this.actors = [];
    this.directors = [];
  }

  ngOnInit() {
    console.log('FilmEditComponent on init');


    this.route.paramMap.subscribe(params => {
      const id: string = params.get('id');
      if (!id) {
        this.isNew = true ;
        this.film = this.modelHelper.createNewFilm() ;
      } else {
        // load the film and the directors and the actors
      }
    });
  }

  save() {
    // if new create if old update
  }

  deleteActor( event ) {
    console.log ('Delete actor ' + event.actorId ) ;

  }

  deleteDirector(event) {
    console.log('Delete director ' + event.directorId);

  }

  openAddActorDialog() {
    const dialogRef = this.dialog.open( AddItemComponent, {
      height: '600px',
      width: '800px',
      data: {
        actor: true,
        searchLabel: 'Recherchez un acteur',
        heading: 'Ajouter un acteur'
      }
    });

    dialogRef.afterClosed().subscribe( result => {
      if (result.actorId) {
        console.log('Add actor id ' + result.actorId);
        this.actorService.getById( result.actorId ).subscribe( actor => {
          this.actors.push(actor);
          this.filmService.addActor( this.film, this.actors, actor).subscribe( res => {
          });
        });
     }
    }) ;
  }

  openAddDirectorDialog() {
    const dialogRef = this.dialog.open(AddItemComponent, {
      height: '600px',
      width: '800px',
      data: {
        director: true,
        searchLabel: 'Recherchez un réalisateur',
        heading: 'Ajouter un réalisateur'
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('Add director id ' + result.directorId);
      if (result.directorId ) {
        this.directorService.getById(result.directorId).subscribe(director => {
          this.directors.push(director);
          this.filmService.addDirector(this.film, this.directors, director).subscribe(res => {
          });
        });
      }
    });
  }
}

