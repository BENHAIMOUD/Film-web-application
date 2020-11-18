import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FilmService } from '../../../services/film.service';
import { Film } from '../../../models/film.model';
import { Observable } from 'rxjs/Observable';
import { forkJoin } from 'rxjs/observable/forkJoin';
import { Director } from '../../../models/director.model';
import { Actor } from '../../../models/actor.model';
import { ModelHelper } from '../../../shared/model.helper';
import { AuthService } from '../../../services/auth.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-film-detail',
  templateUrl: './film-detail.component.html',
  styleUrls: ['./film-detail.component.css']
})
export class FilmDetailComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private filmService: FilmService,
    private authService: AuthService,
    private snackBar: MatSnackBar
  ) {
  }

  protected film: Film;

  protected actors: Actor[];

  protected directors: Director[];

  ngOnInit() {
    console.log('FilmDetailComponent on init') ;
    // get the film id from route params put it in a const id (id is necessary) and load film then load the film's actors/directors
    // in the actors/directors array.
  }

  delete() {
    // delete the actor using the filmservice method open a snackbar with duration 3000 to inform that the film has been deleted and then navigate to ''.

  }
}
