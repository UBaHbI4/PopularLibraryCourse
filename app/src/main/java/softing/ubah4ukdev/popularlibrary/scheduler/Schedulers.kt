package softing.ubah4ukdev.popularlibrary.scheduler

import io.reactivex.Scheduler

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.scheduler

Created by Ivan Sheynmaer

2021.08.15
v1.0
 */
interface Schedulers {

    /**
     * Фоновый поток
     */
    fun background(): Scheduler

    /**
     * Главный поток
     */
    fun main(): Scheduler

    /**
     * Поток для вычислений
     */
    fun computation(): Scheduler
}