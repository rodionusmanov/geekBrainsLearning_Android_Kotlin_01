package com.example.chotamnaulitce.view.contacts

import android.Manifest
import android.app.AlertDialog
import android.content.ContentResolver
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.chotamnaulitce.R
import com.example.chotamnaulitce.databinding.ContactsFragmentBinding
import com.example.chotamnaulitce.utils.REQUEST_CODE_READ_CONTACTS
import com.example.chotamnaulitce.view.citieslist.CitiesListFragment
import okhttp3.Request

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

    private fun checkPermission() {
        val permResult =
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CONTACTS)
        if (permResult == PackageManager.PERMISSION_GRANTED) {
            getContacts()
        } else if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
            AlertDialog.Builder(requireContext())
                .setTitle("Доступ к контактам")
                .setMessage("Запрос на доступ к контактам. В случае отказа, доступ можно будет предоставить только в настройках приложения.")
                .setPositiveButton("Открыть окно предоставления доступа") { _, _ ->
                    permissionRequest(Manifest.permission.READ_CONTACTS)
                }
                .setNegativeButton("Отказать в запросе") { dialog, _ -> dialog.dismiss() }
                .create()
                .show()
        } else {
            permissionRequest(Manifest.permission.READ_CONTACTS)
            AlertDialog.Builder(requireContext())
                .setTitle("Доступ к контактам")
                .setMessage("Доступ к контактам отсутствует. Доступ можно будет предоставить только в настройках приложения.")
                .setPositiveButton("Закрыть сообщение") { dialog, _ ->
                    dialog.dismiss()

                    requireActivity().supportFragmentManager.apply {
                        beginTransaction()
                            .replace(R.id.container, (CitiesListFragment()))
                            .addToBackStack(null)
                            .commitAllowingStateLoss()
                    }
                }
                .create()
                .show()
        }
    }

    private fun permissionRequest(permission: String) {
        requestPermissions(arrayOf(permission), REQUEST_CODE_READ_CONTACTS)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_READ_CONTACTS) {
            for (permsIndex in permissions.indices) {
                if (permissions[permsIndex] == Manifest.permission.READ_CONTACTS && grantResults[permsIndex] == PackageManager.PERMISSION_GRANTED) {
                    getContacts()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
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

        cursorWithContacts?.let {
            for (i in 0..it.count - 1) {
                it.moveToPosition(i)
                val name = it.getString(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                binding.contactsContainer.addView(TextView(requireContext()).apply {
                    text = name
                    textSize = 30f
                })
            }
        }
        cursorWithContacts?.close()
    }
}