package com.noman.currencyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @author Muhammad Noman
 * Here is Application is only created to tell DI this is Application Class
 */
@HiltAndroidApp
class CoinApplicaiton : Application()