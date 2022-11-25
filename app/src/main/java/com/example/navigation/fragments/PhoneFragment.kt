package com.example.navigation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.navArgs
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.example.navigation.databinding.FragmentPhoneBinding


class PhoneFragment : Fragment() {
    private var _binding:FragmentPhoneBinding?=null
    private val binding get() = _binding!!
    private val argsReceived:PhoneFragmentArgs by navArgs()

    private lateinit var  activity:MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.activity = getActivity() as MainActivity
        _binding= FragmentPhoneBinding.inflate(inflater, container, false)
        Toast.makeText(this.context, argsReceived.winOrLoseMessage, Toast.LENGTH_LONG).show()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menuHost:MenuHost= requireActivity()
        menuHost.addMenuProvider(object :MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_share,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when(menuItem.itemId){
                    R.id.shareResults->shareSucces()
                }
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
    private fun getShareIntent():Intent{
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, argsReceived  .sendPhrase)
        return shareIntent
    }

    private fun shareSucces():Boolean{
        startActivity(getShareIntent())
        return true
    }
}