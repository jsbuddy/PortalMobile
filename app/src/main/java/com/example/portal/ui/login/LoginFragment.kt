package com.example.portal.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.portal.R
import com.example.portal.data.model.LoggedInUser
import com.example.portal.databinding.FragmentLoginBinding
import com.example.portal.utils.DrawerLocker
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)?.supportActionBar?.hide()
        (activity as DrawerLocker).setDrawerEnabled(false)
        binding = FragmentLoginBinding.bind(view)

        loginViewModel.loginFormState.observe(viewLifecycleOwner, Observer { loginFormState ->
            if (loginFormState == null) return@Observer
            binding.username.error = null
            binding.password.error = null
            binding.login.isEnabled = loginFormState.isDataValid
            loginFormState.emailError?.let {
                binding.username.error = getString(it)
            }
            loginFormState.passwordError?.let {
                binding.password.error = getString(it)
            }
        })

        loginViewModel.loginResult.observe(viewLifecycleOwner, Observer { loginResult ->
            loginResult ?: return@Observer
            binding.loading.visibility = View.GONE
            loginResult.error?.let {
                showLoginFailed(it)
            }
            loginResult.success?.let {
                updateUiWithUser(it)
            }
        })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                loginViewModel.loginDataChanged(
                    binding.username.text.toString(),
                    binding.password.text.toString()
                )
            }
        }

        binding.container.setOnFocusChangeListener { _view, b ->
            if (b) _view.hideKeyboard()
        }

        binding.username.addTextChangedListener(afterTextChangedListener)
        binding.password.addTextChangedListener(afterTextChangedListener)
        binding.password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (loginViewModel.loginFormState.value?.isDataValid!!) {
                    binding.password.hideKeyboard()
                    loginViewModel.login(
                        binding.username.text.toString(),
                        binding.password.text.toString()
                    )
                }
            }
            false
        }

        binding.login.setOnClickListener {
            it.hideKeyboard()
            binding.loading.visibility = View.VISIBLE
            loginViewModel.login(
                binding.username.text.toString(),
                binding.password.text.toString()
            )
        }
    }

    private fun updateUiWithUser(model: LoggedInUser) {
        val welcome = getString(R.string.welcome) + model.displayName
        Snackbar.make(binding.root, welcome, Snackbar.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_fragment_login_to_nav_home)
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    private fun View.hideKeyboard() {
        val inputMethodManager = requireContext().getSystemService(
            android.content.Context.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }
}