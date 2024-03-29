package pl.coderslab.charity.email;

import pl.coderslab.charity.appuser.AppUser;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.donation.Donation;

import java.util.List;

public abstract class EmailBuilder {
    public static String buildAccountActivationEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Potwierdź swój e-mail</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Witaj, "
                + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> " +
                "Aby dokończyć rejestrację kliknij w poniższy link: " +
                "</p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\">" +
                "<p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\""
                + link + "\">Aktywuj</a> </p></blockquote>\n Link wygaśnie w ciągu 30 minut. <p>Do zobaczenia!</p>" +
                "<br><br><p>Jeżeli uważasz, że to pomyłka, zignoruj tego maila.</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }

    public static String buildDonationSummaryEmail(Donation donation) {
        List<Category> categories = donation.getCategories();
        StringBuilder builder = new StringBuilder();

        for(Category category : categories) {
            builder.append(category.getName()).append(", ");
        }
        String categoriesString = builder.substring(0, builder.lastIndexOf(","));
        return  "  <head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Szczegóły darowizny</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>Dziękujemy za Twoją darowiznę!</h1>\n" +
                "    <hr>\n" +
                "    <p>Witaj " + donation.getAppUser().getFirstName() + ",</p>\n" +
                "    <p>Pragniemy poinformować, że Twój wniosek o darowiznę został przekazany do realizacji. Szczegóły darowizny:</p>\n" +
                "    <ul>\n" +
                "      <li>Dla kogo: " + donation.getInstitution().getName() +"</li>\n" +
                "      <li>Ile worków: " + donation.getQuantity() +"</li>\n" +
                "      <li>Zawartość: " + categoriesString +"</li>\n" +
                "    </ul>\n" +
                "    <p>Państwa darowizna zostanie odebrana przez kuriera w dniu:</p>\n" +
                "    <ul>\n" +
                "      <li>Data: " + donation.getPickUpDate().toString() + "</li>\n" +
                "      <li>Godzina: " + donation.getPickUpTime().toString() +  "</li>\n" +
                "       <li>Uwagi dotyczące odbioru: " + donation.getPickUpComment() + "</li>\n" +
                "    </ul>\n" +
                "    <p>Adres odbioru:</p>\n" +
                "    <ul>\n" +
                "        <li>"+ donation.getStreet() + " </li>\n" +
                "        <li>"+ donation.getCity() + " </li>\n" +
                "        <li>"+ donation.getZipCode() + " </li>\n" +
                "        <li>Telefon kontaktowy: "+ donation.getPhone() +  "</li>\n" +
                "    </ul>\n" +
                "    <p>Jeżeli masz jakiekolwiek wątpliwości, skontaktuj się z nami odpowiadając na tego emaila.</p>\n" +
                "    <p>Dziękujemy,</p>\n" +
                "    <p>Charity Donation</p>\n" +
                "  </body>\n";
    }

    public static String buildPasswordResetEmail(AppUser user, String token) {
        String link = "http://localhost:8080/pass-reset/confirm?token=" + token + "&user_id=" + user.getId();

        return  "  <head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Reset hasła</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>Reset hasła</h1>\n" +
                "    <hr>\n" +
                "    <p>Witaj " + user.getFirstName() + ",</p>\n" +
                "    <p>Aby ustawić nowe hasło, kliknij w poniższy link:</p>\n" +
                "    <a href=\"" + link + "\">Resetuj hasło</a>" +
                "    <p>Jeżeli uważasz,że to pomyłka, zignoruj tę wiadomość</p>\n" +
                "    <p>Dziękujemy,</p>\n" +
                "    <p>Charity Donation</p>\n" +
                "  </body>\n";

    }
}
