package com.example.telegram.ui.screens.settings

import com.example.telegram.R
import com.example.telegram.database.*
import com.example.telegram.ui.screens.base.BaseChangeFragment
import com.example.telegram.utils.*
import kotlinx.android.synthetic.main.fragment_change_name.*

/* Фрагмент для изменения имени пользователя */

class ChangeNameFragment : BaseChangeFragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
        initFullnameList()
    }

    private fun initFullnameList() {
        val fullNameList = USER.fullname.split(" ")
        if (fullNameList.size > 1) {
            settings_input_name.setText(fullNameList[0])
            settings_input_surname.setText(fullNameList[1])
        } else settings_input_name.setText(fullNameList[0])
    }

    override fun change() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) {
            showToast(getString(R.string.settings_toast_name_is_empty))
        } else {
            setNameToDatabase("$name $surname")
        }
    }
}
