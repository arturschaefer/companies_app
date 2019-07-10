package com.schaefer.companiesapp.interactor

import com.schaefer.companiesapp.interactor.service.CompaniesService
import javax.inject.Inject

class EnterpriseDetailInteractor @Inject constructor(
    private val companiesService: CompaniesService
)