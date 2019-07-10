package com.schaefer.companiesapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.schaefer.companiesapp.R
import com.schaefer.companiesapp.entity.enterprise.Enterprise
import com.schaefer.companiesapp.entity.utils.Utils
import com.schaefer.companiesapp.presenter.EnterpriseDetailPresenter
import com.schaefer.companiesapp.view.utils.enterpriseDetailComponent
import kotlinx.android.synthetic.main.activity_enterprise_details.*
import kotlinx.android.synthetic.main.layout_toolbar_general.*
import kotlinx.android.synthetic.main.layout_toolbar_general.view.*
import javax.inject.Inject

class EnterpriseDetailActivity : AppCompatActivity() {
    @Inject
    lateinit var presenter: EnterpriseDetailPresenter

    //region - Lifecycle methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enterprise_details)
        enterpriseDetailComponent.inject(this)
        Utils.changeColorStatusBar(window, this, R.color.colorPrimaryDark)

        //ConfigToolbar
        setSupportActionBar(toolbar)
        toolbar.imageView_arrow_back.setOnClickListener { onBackPressed() }

        presenter.getIntentValues()
    }

    fun setDetails(enterpriseDetail: Enterprise?) {
        textView_toolbar_title.text = enterpriseDetail?.enterprise_name
        Glide
            .with(this)
            .load(enterpriseDetail?.photo)
            .centerCrop()
            .error(R.drawable.enterprise_placeholder)
            .into(imageView_companie_item)
        textView_enterprise_detail.text = enterpriseDetail?.description
    }
}