import { HomeComponent } from './home.component';
import { UpdateComponent } from './update.component';
import { InfoComponent } from './info.component';
import { FeedComponent } from './feed.component';
import { ControlComponent } from './control.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login.component';
import { ProfilComponent } from './profil.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },

  { path: '/home', component: HomeComponent },
  { path: '/control', component: ControlComponent },
  { path: '/feed', component: FeedComponent },
  { path: '/info', component: InfoComponent },
  { path: '/update', component: UpdateComponent },
  { path: '**', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: false })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
