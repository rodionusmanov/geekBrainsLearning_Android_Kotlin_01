package com.example.chotamnaulitce.view.contacts

import android.Manifest
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.databinding.ContactsFragmentBinding

class ContactsFragment : Fragment() {

    private var _binding: ContactsFragmentBinding? = null
    private val binding: ContactsFragmentBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ContactsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
    }

    fun checkPermission() {
        val permResult =
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CONTACTS)
        if (permResult == PackageManager.PERMISSION_GRANTED){
            getContacts()
        }
    }

    private fun getContacts() {
        val contentResolver: ContentResolver = requireContext().contentResolver
        val cursorWithContacts: Cursor? = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.Contacts.DISPLAY_NAME + " ASC"
        )
    }
}