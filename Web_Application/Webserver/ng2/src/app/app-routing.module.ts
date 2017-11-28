import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PositionComponent } from './position.component';
import { HomeComponent } from './home.component';
import { FeedComponent } from './feed.component';
import { InfoComponent } from './info.component';
import { UpdateComponent } from './update.component';
import { Error404Component } from './error404.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent, data: { title: 'Füttr' } },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'position', component: PositionComponent, data: { title: 'Füttr - Positionen' } },
  { path: 'feed', component: FeedComponent, data: { title: 'Füttr - Fütterung' } },
  { path: 'info', component: InfoComponent, data: { title: 'Füttr - Info' } },
  { path: 'update', component: UpdateComponent, data: { title: 'Füttr - Update' } },
  { path: '**', component: Error404Component, data: { title: 'Füttr - 404 (not found)' } }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
