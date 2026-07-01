package com.example.socialapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.net.Uri;


public class Fragment5 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_5, container, false);

        Button alumniButton = view.findViewById(R.id.iamalumni_btn);

        alumniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display alumni information in a pop-up dialog
                showInfoDialog("Alumni Info", "https://docs.google.com/forms/d/e/1FAIpQLScqENANDu2CLeBRn0I6LM54Ox_yQLLrgaecb44I51FE1NEfJQ/viewform?usp=sf_link", true);
            }
        });

        Button studentButton = view.findViewById(R.id.iamstudent_btn);

        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display student information in a pop-up dialog
                showInfoDialog("Student Info", "https://docs.google.com/forms/d/e/1FAIpQLSc67Erdj42QHjuol1HkwAt5TjrD0vKXOiDyP1koR0yRm6upjw/viewform?usp=sf_link", true);
            }
        });

        Button guidelinesButton = view.findViewById(R.id.buttonGuidelines);

        guidelinesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display guidelines in a pop-up dialog without a link
                showGuidelinesDialog("Guidelines Info", "It is mandatory to fill out this form as it helps us gather essential information. Your responses are valuable to us, and they will be kept confidential.\n" +
                        "\n" +
                        "1. Accessing the Form:\n" +
                        "\n" +
                        "Click on the link provided or visit the designated webpage to access the Google Form.\n" +
                        "Make sure you are logged into your Google account (if required) before proceeding.\n" +
                        "2. Complete All Required Fields:\n" +
                        "\n" +
                        "Fields marked with an asterisk (*) are mandatory. Please provide information in these fields to submit the form successfully.\n" +
                        "Optional fields may also be included; you are encouraged to fill them out to provide us with more context or feedback.\n" +
                        "3. Accuracy and Clarity:\n" +
                        "\n" +
                        "Ensure that your responses are accurate and clearly presented. Double-check for any spelling errors or typos.\n" +
                        "Use appropriate capitalization and punctuation where necessary.\n" +
                        "4. Use Proper Format:\n" +
                        "\n" +
                        "When providing numerical data (e.g., dates, phone numbers, or email addresses), use the correct format as specified in the form.\n" +
                        "If you are required to upload documents, make sure they are in the requested format (e.g., PDF, JPG, or DOCX).\n" +
                        "5. Stay Focused:\n" +
                        "\n" +
                        "Answer the questions or provide the requested information without going off-topic.\n" +
                        "Avoid irrelevant comments or information that does not pertain to the form's purpose.\n" +
                        "6. Submitting the Form:\n" +
                        "\n" +
                        "After completing the form, review your responses to ensure accuracy and completeness.\n" +
                        "Click the \"Submit\" button at the end of the form to send your responses.\n" +
                        "7. Contact Information:\n" +
                        "\n" +
                        "If you encounter technical issues or have questions related to the form, please contact our support team using the provided contact details.\n" +
                        "8. Data Privacy:\n" +
                        "\n" +
                        "Rest assured that your responses will be treated with the utmost confidentiality and used solely for the intended purpose");
            }
        });

        return view;
    }

    private void showInfoDialog(String title, final String link, boolean showLinkOption) {
        // Create an AlertDialog to display information
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(title);
        builder.setMessage("Would you like to follow the link or close the dialog?");

        // Add a "Close" button to dismiss the dialog
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Optionally add a "Follow Link" button if showLinkOption is true
        if (showLinkOption) {
            builder.setNegativeButton("Follow Link", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Open the link in a web browser
                    openLink(link);
                    dialog.dismiss();
                }
            });
        }

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showGuidelinesDialog(String title, String message) {
        // Create an AlertDialog to display guidelines without a link
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(title);
        builder.setMessage(message);

        // Add a "Close" button to dismiss the dialog
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void openLink(String url) {
        // Create an Intent to open a web page
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
