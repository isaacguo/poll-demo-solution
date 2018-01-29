import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {IndexComponent} from "./app/components/index/index.component";
import {ResultComponent} from "./app/components/result/result.component";


const appRoutes: Routes = [
  {
    path: '',
    component: IndexComponent
  },
  {
    path: 'result',
    component: ResultComponent
  },
  // otherwise redirect to home
  {path: '**', redirectTo: ''}

]


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
