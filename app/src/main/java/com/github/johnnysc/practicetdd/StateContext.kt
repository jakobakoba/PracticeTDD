package com.github.johnnysc.practicetdd

interface StateContext {

    interface Actions {
        fun log(logging: Logging)
        fun next()
    }

    interface Update {
        fun updateState(state: State)
    }

    class Base(state: State) : Update, Actions {
        private var innerState: State = state

        override fun updateState(state: State) {
            innerState = state
        }

        override fun log(logging: Logging) {
            logging.log(innerState.toString())
        }

        override fun next() {
            innerState.next(context = this)
        }

    }
}