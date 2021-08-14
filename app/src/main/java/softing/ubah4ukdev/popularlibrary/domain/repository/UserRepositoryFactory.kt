package softing.ubah4ukdev.popularlibrary.domain.repository

/****
Project PopularLibrary
Package softing.ubah4ukdev.popularlibrary.domain.repository

Created by Ivan Sheynmaer

2021.08.14
v1.0
 */
object UserRepositoryFactory {

    fun create(): IUsersRepository = MockUsersRepositoryImpl()
}