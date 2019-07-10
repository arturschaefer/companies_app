package com.schaefer.companiesapp.view

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.orhanobut.logger.Logger
import com.schaefer.companiesapp.R
import com.schaefer.companiesapp.entity.enterprise.Enterprises
import com.schaefer.companiesapp.entity.utils.Utils.changeColorStatusBar
import com.schaefer.companiesapp.presenter.HomePresenter
import com.schaefer.companiesapp.view.adapters.EnterpriseAdapter
import com.schaefer.companiesapp.view.utils.homeActivityComponent
import com.transitionseverywhere.ChangeBounds
import com.transitionseverywhere.TransitionManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.layout_toolbar_logo.*
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), EnterpriseAdapter.ClickListener {
    //region - Local members
    private var toast: Toast? = null
    @Inject
    lateinit var presenter: HomePresenter
    //endregion

    //region - Lifecycle methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeActivityComponent.inject(this)
        changeColorStatusBar(window, this, R.color.colorPrimaryDark)

        presenter.getIntentValues()
        setSupportActionBar(toolbar)
        configSearchView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }
    //endregion


    //others - Functions
    fun showMessageError(message: String) {
        toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
        toast?.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        val item = menu.findItem(R.id.action_search)
        search_view.setMenuItem(item)
        return true
    }

    fun successGetEnterprises(list: Enterprises?) {
        TransitionManager.beginDelayedTransition(linearLayout_home, ChangeBounds())
        if (list != null) {
            recycler_search.visibility = View.VISIBLE
            textView_empty_search.visibility = View.GONE
            recycler_search.adapter = EnterpriseAdapter(list.enterprises, this, this)
        } else {
            textView_empty_search.visibility = View.VISIBLE
            recycler_search.visibility = View.GONE
        }
        recycler_search.layoutManager = LinearLayoutManager(this)
    }

    override fun onClick(position: Int) {
        presenter.onClickOnItem(position)
    }
    //endregion

    //region - Config the searchView
    private fun configSearchView() {
        search_view.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                presenter.getEnterprisesByName(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        search_view.setOnSearchViewListener(object : MaterialSearchView.SearchViewListener {
            override fun onSearchViewShown() {
                configMenu(false)
                Logger.d("searchViewShown")
            }

            override fun onSearchViewClosed() {
                configMenu(true)
                Logger.d("searchViewClose")
            }
        })
    }

    private fun configMenu(isClosed: Boolean) {
        if (isClosed) {
            imageView_logo_toolbar.visibility = View.VISIBLE
            if (!toolbar.menu.hasVisibleItems()) {
                menuInflater.inflate(R.menu.menu_home, toolbar.menu)
                val item = toolbar.menu.findItem(R.id.action_search)
                search_view.setMenuItem(item)
            }
        } else {
            imageView_logo_toolbar.visibility = View.GONE
            toolbar.menu.clear()
        }
    }

    override fun onBackPressed() {
        if (search_view.isSearchOpen) {
            search_view.closeSearch()
        } else {
            super.onBackPressed()
        }
    }
    //endregion
}