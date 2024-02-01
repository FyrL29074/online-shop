package com.fyrl29074.auth.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.fyrl29074.auth.databinding.FragmentAuthBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFlow()
        initButtons()
    }

    private fun initFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                state.handle()
            }
        }
    }

    private fun initButtons() {
        binding.auth.setOnClickListener {
            val name = binding.name.text.toString()
            val surname = binding.surname.text.toString()
            val phone = binding.phone.text.toString()

            viewModel.auth(name, surname, phone)
        }
    }

    private fun AuthState.handle() {
        when (this) {
            AuthState.Waiting -> {
                binding.progressBar.isVisible = false
                binding.auth.isEnabled = true
            }

            AuthState.Loading -> {
                binding.progressBar.isVisible = true
                binding.auth.isEnabled = false
            }

            AuthState.Success -> {
                // TODO: navigate to the main screen
            }

            is AuthState.Error -> {
                binding.progressBar.isVisible = false
                binding.auth.isEnabled = true
                Toast.makeText(
                    /* context = */  requireContext(),
                    /* text = */     message,
                    /* duration = */ Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}