package com.example.dicodingaplikasi.ui.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import com.example.dicodingaplikasi.R
import com.google.android.material.switchmaterial.SwitchMaterial


class DarkMode : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dark_mode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cari view SwitchMaterial dari layout fragment
        val switchTheme = view.findViewById<SwitchMaterial>(R.id.switch_theme)

        val pref = SettingPreferences.getInstance(application.dataStore)
        val mainViewModel = SettingViewModelFactory(this, SettingViewModelFactory(pref)).get(
            SettingViewModel::class.java)

        // Listener untuk perubahan pada switch
        switchTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                switchTheme.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                switchTheme.isChecked = false
            }

            switchTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked: Boolean ->
                SettingViewModel.saveThemeSetting(isChecked)
            }
        }
    }

}
