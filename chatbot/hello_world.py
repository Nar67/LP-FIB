# importing Telegram API
from telegram.ext import Updater
from telegram.ext import CommandHandler
# defining callback function for the /start command
def start(bot, update):
    bot.send_message(chat_id=update.message.chat_id, text="Yai n00b")
# loading the access token from token.txt
TOKEN = open('token.txt').read().strip()
# call main Telegram objects
updater = Updater(token=TOKEN)
dispatcher = updater.dispatcher
# handling callbacks functions to the commands
dispatcher.add_handler(CommandHandler('start', start))
# starting the bot
updater.start_polling()