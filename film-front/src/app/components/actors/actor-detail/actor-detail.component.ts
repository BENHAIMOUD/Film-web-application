import { Component, OnInit } from '@angular/core';
import { Actor } from '../../../models/actor.model';
import { Film } from '../../../models/film.model';
import { ActivatedRoute, Router } from '@angular/router';
import { ActorService } from '../../../services/actor.service';
import { AuthService } from '../../../services/auth.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-actor-detail',
  templateUrl: './actor-detail.component.html',
  styleUrls: ['./actor-detail.component.css']
})
export class ActorDetailComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private actorService: ActorService,
    private authService: AuthService,
    private snackBar: MatSnackBar
  ) { }

  protected actor: Actor;

  protected films: Film[];


  ngOnInit() {
    console.log('ActorDetailComponent on init');
    // get the actor id from route params put it in a const id (id is necessary) and load actor then load the actors films in the films array.
  }

  delete() {
    // delete the actor using the actirservice.delete method open a snackbar with duration 3000 to inform that the actor has been deleted and then navigate to ''.
  }

}
