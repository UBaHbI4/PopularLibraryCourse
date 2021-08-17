package softing.ubah4ukdev.popularlibrary.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.scheduler

Created by Ivan Sheynmaer

2021.08.15
v1.0
 */
class DefaultSchedulers : Schedulers {

    override fun background(): Scheduler = io.reactivex.schedulers.Schedulers.newThread()

    override fun computation(): Scheduler = io.reactivex.schedulers.Schedulers.computation()

    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}