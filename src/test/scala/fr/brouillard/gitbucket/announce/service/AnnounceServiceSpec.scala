package fr.brouillard.gitbucket.announce.service

import org.scalatest.funsuite.AnyFunSuite

class AnnounceServiceSpec extends AnyFunSuite {

  test("accepts plain addresses") {
    assert(EmailAddress.isValid("user@example.com"))
    assert(EmailAddress.isValid("USER@EXAMPLE.COM"))
    assert(EmailAddress.isValid("user.name@sub.example.com"))
  }

  test("accepts addresses with an apostrophe in the local part") {
    assert(EmailAddress.isValid("o'brien@example.com"))
  }

  test("accepts other RFC 5322 atext characters in the local part") {
    assert(EmailAddress.isValid("user+tag@example.com"))
    assert(EmailAddress.isValid("user_name@example.com"))
    assert(EmailAddress.isValid("user-name@example.com"))
  }

  test("rejects addresses without an @") {
    assert(!EmailAddress.isValid("not-an-email"))
  }

  test("rejects addresses with spaces") {
    assert(!EmailAddress.isValid("user name@example.com"))
  }

  test("rejects empty string") {
    assert(!EmailAddress.isValid(""))
  }
}
