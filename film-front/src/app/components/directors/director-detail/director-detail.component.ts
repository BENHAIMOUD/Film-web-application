import { Component, OnInit } from '@angular/core';
import { Director } from '../../../models/director.model';
import { Film } from '../../../models/film.model';
import { ActivatedRoute, Router } from '@angular/router';
import { DirectorService } from '../../../services/director.service';
import { AuthService } from '../../../services/auth.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-director-detail',
  templateUrl: './director-detail.component.html',
  styleUrls: ['./director-detail.component.css']
})
export class DirectorDetailComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private directorService: DirectorService,
    private authService: AuthService,
    private snackBar: MatSnackBar
  ) { }

  protected director: Director;

  protected films: Film[];


  ngOnInit() {
    console.log('DirectorDetailComponent on init');
    // get the director id from route params and load director and his films

  }

  delete() {

  }
}
