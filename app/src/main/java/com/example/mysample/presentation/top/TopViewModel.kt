package com.example.mysample.presentation.top

import androidx.databinding.BaseObservable
import javax.inject.Inject

class TopViewModel @Inject constructor(val topContentAdapter: TopContentAdapter) : BaseObservable() {

    fun load() {
        topContentAdapter.add(listOf(
            "fjlasjfdlkasjfiasjealiwjrfwli",
            "fjasfjaslkfjdsalk",
            "jfasjdfiawejalfjwijfldsafkjaslfhsdalhf;lahsfeiwufla;iwflaiwjfalewj",
            "fdjlaskjflajseawil",
            "jlfdkasjfiaowejlajldksj",
            "flajfdoiaejawj",
            "fldaskjfliweajflewjfladsjfljhdsfljheloijweijfeaw;ljaliwjfliawejfhlaihwflawho;lehawj",
            "flk,djflaijfoawjfl",
            "fjdaslfjlaiewflawjfasdfh;lawhrl;awfadslhf"
        ))
    }
}