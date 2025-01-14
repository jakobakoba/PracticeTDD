package com.github.johnnysc.practicetdd

interface State {

    fun next(context: StateContext.Update)

    data object RequireLogin : State {
        override fun next(context: StateContext.Update) {
            context.updateState(State.LoginSuccessfully)
        }
    }

    data object LoginSuccessfully : State {
        override fun next(context: StateContext.Update) {

        }

    }
}