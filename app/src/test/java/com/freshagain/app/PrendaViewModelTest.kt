package com.freshagain.app

import com.freshagain.app.data.PrendaRepository
import com.freshagain.app.model.Prenda
import com.freshagain.app.viewmodel.PrendaViewModel
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class PrendaViewModelTest : StringSpec({

    val dispatcher = StandardTestDispatcher()
    beforeTest { Dispatchers.setMain(dispatcher) }
    afterTest { Dispatchers.resetMain() } {
        val listaFalsa = listOf(
            Prenda(1, "Polera Test", "Desc", 1000, ""),
            Prenda(2, "Pantalón Test", "Desc", 2000, "")
        )
        val repositorioMock = mockk<PrendaRepository>()

        coEvery { repositorioMock.obtenerPrendas() } returns listaFalsa

        val viewModel = PrendaViewModel(repositorioMock)

        dispatcher.scheduler.advanceUntilIdle()

        viewModel.prendas.value shouldBe listaFalsa
        viewModel.prendas.value.size shouldBe 2
    }{
        val repositorioMock = mockk<PrendaRepository>()
        coEvery { repositorioMock.obtenerPrendas() } returns emptyList()

        val viewModel = PrendaViewModel(repositorioMock)
        dispatcher.scheduler.advanceUntilIdle()

        viewModel.prendas.value shouldBe emptyList()
    }
})