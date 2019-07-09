package com.schaefer.companiesapp.interactor

import com.schaefer.companiesapp.interactor.service.CompaniesService
import javax.inject.Inject

class HomeInteractor @Inject constructor(
    private val companiesService: CompaniesService
) {
}